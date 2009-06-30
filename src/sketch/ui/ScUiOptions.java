package sketch.ui;

/**
 * command line options for the user interface
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
public class ScUiOptions extends sketch.util.CliOptGroup {
    Boolean dis;

    public ScUiOptions() {
        prefixes("ui");
        add("--no_gui", "disable the GUI (not recommended)");
        add("--no_auto_soln_disp",
                "don't automatically display the first solution");
        add("--accept_gen_filename", "out.scala", "scala file to generate "
                + "after \"accept\" is clicked");
        add("--context_len", 3,
                "number of lines surrounding the line of interest");
        add("--context_split_len", 9,
                "maximum amount of context between lines before they are split");
    }
}
