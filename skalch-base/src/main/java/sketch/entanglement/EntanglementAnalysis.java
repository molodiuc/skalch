package sketch.entanglement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sketch.entanglement.graph.ScGraph;

public class EntanglementAnalysis {

    private final List<Trace> traces;
    private HashMap<DynAngel, ArrayList<Integer>> angelsToValueMap;
    private Set<DynAngelPair> entangledAngelPairs;

    public EntanglementAnalysis(Collection<Trace> traces) {
        this.traces = new ArrayList<Trace>(traces);
        angelsToValueMap = getAngelsToValuesMap(this.traces);
        entangledAngelPairs = getEntangledPairs();
    }

    private HashMap<DynAngel, ArrayList<Integer>> getAngelsToValuesMap(List<Trace> traces)
    {
        HashMap<DynAngel, ArrayList<Integer>> dynamicAngelsToValues =
                new HashMap<DynAngel, ArrayList<Integer>>();

        // go through every trace
        for (int i = 0; i < traces.size(); i++) {
            // go through every dynamic angelic call
            Trace trace = traces.get(i);
            for (Event event : trace.events) {
                DynAngel dynAngel = event.dynAngel;
                ArrayList<Integer> values;
                // add valueChosen to correct list
                if (dynamicAngelsToValues.containsKey(dynAngel)) {
                    values = dynamicAngelsToValues.get(dynAngel);
                } else {
                    values = new ArrayList<Integer>();
                    dynamicAngelsToValues.put(dynAngel, values);
                }
                // if the dynamic angel was not accessed in the previous traces,
                // then we need to pad the list until the index
                while (values.size() < i) {
                    values.add(-1);
                }
                values.add(event.valueChosen);
            }
        }

        // pad all the lists so they are the same size
        for (DynAngel dynamicAngel : dynamicAngelsToValues.keySet()) {
            ArrayList<Integer> values = dynamicAngelsToValues.get(dynamicAngel);
            while (values.size() < traces.size()) {
                values.add(-1);
            }
        }

        return dynamicAngelsToValues;
    }

    private Set<DynAngelPair> getEntangledPairs() {
        // list of all dynamic angels
        ArrayList<DynAngel> dynamicAngels = new ArrayList<DynAngel>();
        dynamicAngels.addAll(angelsToValueMap.keySet());
        HashSet<DynAngelPair> entangledPairs = new HashSet<DynAngelPair>();

        for (int i = 0; i < dynamicAngels.size(); i++) {
            for (int j = 0; j < dynamicAngels.size(); j++) {
                if (i == j) {
                    continue;
                }

                Set<DynAngel> proj1 = new HashSet<DynAngel>();
                proj1.add(dynamicAngels.get(i));

                Set<DynAngel> proj2 = new HashSet<DynAngel>();
                proj2.add(dynamicAngels.get(j));

                if (compareTwoSubtraces(proj1, proj2).isEntangled) {
                    entangledPairs.add(new DynAngelPair(dynamicAngels.get(i),
                            dynamicAngels.get(j)));
                }
            }
        }
        return entangledPairs;
    }

    public Set<DynAngelPair> getAllEntangledPairs() {
        return new HashSet<DynAngelPair>(entangledAngelPairs);
    }

    public EntanglementComparison compareTwoSubtraces(Set<DynAngel> proj1,
            Set<DynAngel> proj2)
    {
        Set<DynAngel> projUnion = new HashSet<DynAngel>();
        projUnion.addAll(proj1);
        projUnion.addAll(proj2);

        Set<Trace> proj1TraceSet = new HashSet<Trace>();
        Set<Trace> proj2TraceSet = new HashSet<Trace>();
        Set<Trace> projUnionTraceSet = new HashSet<Trace>();

        for (Trace trace : traces) {
            proj1TraceSet.add(trace.getSubTrace(proj1));
            proj2TraceSet.add(trace.getSubTrace(proj2));
            projUnionTraceSet.add(trace.getSubTrace(projUnion));
        }

        List<Trace> proj1TraceList = new ArrayList<Trace>(proj1TraceSet);
        List<Trace> proj2TraceList = new ArrayList<Trace>(proj2TraceSet);

        // default value is false
        int[][] correlationMap = new int[proj1TraceList.size()][proj2TraceList.size()];

        for (int i = 0; i < correlationMap.length; i++) {
            for (int j = 0; j < correlationMap[0].length; j++) {
                correlationMap[i][j] = 0;
            }
        }

        for (int i = 0; i < proj1TraceList.size(); i++) {
            for (int j = 0; j < proj2TraceList.size(); j++) {
                for (Trace unionTrace : projUnionTraceSet) {
                    if (unionTrace.getSubTrace(proj1).equals(proj1TraceList.get(i)) &&
                            unionTrace.getSubTrace(proj2).equals(proj2TraceList.get(j)))
                    {
                        correlationMap[i][j]++;
                        break;
                    }
                }
            }
        }

        EntanglementComparison ec =
                new EntanglementComparison(proj1, proj2, proj1TraceList, proj2TraceList,
                        correlationMap);
        return ec;
    }

    public Set<DynAngel> getConstantAngels() {
        HashMap<DynAngel, Boolean> isConstantAngel = new HashMap<DynAngel, Boolean>();
        HashMap<DynAngel, Integer> angelValues = new HashMap<DynAngel, Integer>();

        // go through every trace
        for (Trace trace : traces) {
            // go through every angelic call
            for (Event angelicCall : trace.events) {
                DynAngel location = angelicCall.dynAngel;
                // if the location is already visited and is said to be constant
                if (isConstantAngel.keySet().contains(location) &&
                        isConstantAngel.get(location))
                {
                    // check if location is still constant
                    if (!angelValues.get(location).equals(angelicCall.valueChosen)) {
                        isConstantAngel.put(location, false);
                    }
                } else {
                    // check if first time visiting location
                    if (!isConstantAngel.keySet().contains(location)) {
                        isConstantAngel.put(location, true);
                        angelValues.put(location, angelicCall.valueChosen);
                    }
                }
            }
        }
        Set<DynAngel> constantAngels = new HashSet<DynAngel>();
        for (DynAngel angel : isConstantAngel.keySet()) {
            if (isConstantAngel.get(angel)) {
                constantAngels.add(angel);
            }
        }
        return constantAngels;
    }

    public Set<DynAngel> getEntangledAngels() {
        HashSet<DynAngel> entangledAngels = new HashSet<DynAngel>();
        for (DynAngelPair pair : entangledAngelPairs) {
            entangledAngels.add(pair.getFirst());
            entangledAngels.add(pair.getSecond());
        }
        return entangledAngels;
    }

    public Set<Trace> getPossibleValues(HashSet<DynAngel> proj) {
        Set<Trace> projTraceSet = new HashSet<Trace>();
        for (Trace trace : traces) {
            projTraceSet.add(trace.getSubTrace(proj));
        }
        return projTraceSet;
    }

    public List<List<DynAngel>> getOneEntangledSubsets() {
        ScGraph<DynAngel> entanglementGraph = new ScGraph<DynAngel>();
        for (DynAngel angel : angelsToValueMap.keySet()) {
            entanglementGraph.addVertex(angel);
        }

        for (DynAngelPair entangledAngels : entangledAngelPairs) {
            entanglementGraph.addEdge(entangledAngels.loc1, entangledAngels.loc2);
        }
        return entanglementGraph.getConnectedComponents();
    }

    public List<List<DynAngel>> getNEntangledSubsets(int n) {
        List<List<DynAngel>> entangledSubsets = getOneEntangledSubsets();
        for (int i = 2; i < n; i++) {
            ScGraph<List<DynAngel>> graph = new ScGraph<List<DynAngel>>();
            for (List<DynAngel> subset : entangledSubsets) {
                graph.addVertex(subset);
            }
            SubsetIterator iterator = new SubsetIterator(i, entangledSubsets.size());
            while (iterator.hasNext()) {
                iterator.next();
                HashSet<DynAngel> firstSubset = new HashSet<DynAngel>();
                HashSet<DynAngel> secondSubset = new HashSet<DynAngel>();

                for (Integer index : iterator.firstSubset()) {
                    firstSubset.addAll(entangledSubsets.get(index));
                }
                for (Integer index : iterator.secondSubset()) {
                    secondSubset.addAll(entangledSubsets.get(index));
                }
                EntanglementComparison result =
                        compareTwoSubtraces(firstSubset, secondSubset);
                if (result.isEntangled) {
                    for (Integer index1 : iterator.firstSubset()) {
                        for (Integer index2 : iterator.secondSubset()) {
                            graph.addEdge(entangledSubsets.get(index1),
                                    entangledSubsets.get(index2));
                        }
                    }
                }
            }
            List<List<List<DynAngel>>> connectedComponents =
                    graph.getConnectedComponents();
            entangledSubsets.clear();
            for (List<List<DynAngel>> connectedComponent : connectedComponents) {
                List<DynAngel> allDynAngels = new ArrayList<DynAngel>();
                for (List<DynAngel> node : connectedComponent) {
                    allDynAngels.addAll(node);
                }
                entangledSubsets.add(allDynAngels);
            }
        }
        // entangledSubsets.clear();
        return entangledSubsets;
    }
}
