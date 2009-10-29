#!/usr/bin/env python
# -*- coding: utf-8 -*-
# Copyright 2009 gatoatigrado (nicholas tung) [ntung at ntung]

# Licensed under the Apache License, Version 2.0 (the "License"); you may
# not use this file except in compliance with the License. You may obtain a
# copy of the License at http://www.apache.org/licenses/LICENSE-2.0 .

from __future__ import division, print_function
from collections import namedtuple
import re, sys

try:
    # Path, ExecuteIn, SubProc, sort()
    from gatoatigrado_lib import *
except ImportError, e:
    import sys; print("please install gatoatigrado's utility library from "
        "bitbucket.org/gatoatigrado/gatoatigrado_lib", file=sys.stderr)

mundane = [re.compile("^%s$" %(v)) for v in r"""
Model assembly "" generated.
GrShell v2.+
New graph "DefaultGraph" and actions created.+
Graph "DefaultGraph" imported.
import done after:.+
graph size after import: .+
shell import done after: .+
shell graph size after import: .+
Number of (nodes|edges) compatible to type.+
Executing Graph Rewrite Sequence.+
.+matches found
.+rewrites performed
The graph is valid with respect to the given sequence.
Building libraries\.\.\.
(\> )?Bye\!
 - (Model|Actions) assembly "([^"]+)" generated.*
Graph "DefaultGraph" exported.*
Warning: Unknown Statement.+
""".splitlines() if v]

def main(grs_template=None, output_file=None, gxl_file=None, debug=False, runonly=False, ycomp=False):
    assert grs_template
    if not gxl_file:
        gxl_file = Path("~/.sketch/tmp/input.gxl")
        gxl_file.write(sys.stdin.read())
    output_file = Path(output_file or "~/.sketch/tmp/output.gxl")
    gxl_file = Path(gxl_file)
    endstr = "debug enable" if ycomp else "exit"
    grs_file = Path("~/.sketch/tmp/transform.grs")
    grs_file.write(Path(grs_template).read() %(locals()))
    # to slow down: substitue e.g. "%(gxl_file)s" in the template file,
    # which is stored in the same directory as this script.

    grshell = Path.resolve("grshell", "GrShell")
    proc = SubProc([grshell, grs_file])
    with ExecuteIn(Path("!")):
        if runonly:
            return (proc.start(), proc.proc.wait())[-1]
        with proc.kill_on_fail():
            assert_next = None
            fail_on_next = False
            for line in proc.exec_lines():
                if line.startswith("[GRG ASSERT FAILURE] "):
                    print(line)
                    fail_on_next = True
                else:
                    assert not fail_on_next, \
                        "Stopping now from previous failures (see above)"
                if not assert_next is None:
                    assert line == assert_next, "didn't match assert"
                    assert_next = None
                elif any(v.match(line) for v in mundane): pass
                elif not line: pass
                elif line.startswith("[REWRITE PRODUCTION] "):
                    print(line)
                elif line.startswith("[ASSERT NEXT LINE] "):
                    assert_next = line.replace("[ASSERT NEXT LINE] ", "")
                elif line.startswith("[GRG ASSERT FAILURE] "):
                    print(line)
                #elif line.endswith("matches found"): pass
                #elif line.endswith("rewrites performed"): pass
                #elif line.endswith("is valid with respect to"): pass
                #elif line.startswith("GrShell "): pass
                #elif line == "Building libraries...": pass
                elif debug:
                    print("unrecognized line %r" %(line))
                else:
                    if line == "Unable to import graph: Object reference not set to an instance of an object":
                        print("""\n\n\nNOTE -- maybe you added an attribute not set in the
grammar, or forgot to make a new node class inherit ScAstNode?\n\n\n""")
                    raise Exception("unrecognized line %r" %(line))

if __name__ == "__main__":
    import optparse
    cmdopts = optparse.OptionParser(usage="%prog [options] args")
    cmdopts.add_option("--grs_template", default="!/transform.template.grs",
        help="location of grs template")
    cmdopts.add_option("--gxl_file",
        help="gxl file, default stdin and saved to ~/.sketch/tmp/input.gxl")
    cmdopts.add_option("--output_file",
        help="gxl file to export after lowering")
    cmdopts.add_option("--debug", action="store_true",
        help="debug settings (use when developing)")
    cmdopts.add_option("--runonly", action="store_true",
        help="only fork off grgen, don't process output")
    cmdopts.add_option("--ycomp", action="store_true",
        help="visualize output instead of exiting (type exit later to exit")
    options, args = cmdopts.parse_args()
    try:
        main(*args, **options.__dict__)
    except KeyboardInterrupt, e: pass

