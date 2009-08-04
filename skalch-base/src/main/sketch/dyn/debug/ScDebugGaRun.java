package sketch.dyn.debug;

import sketch.dyn.ctrls.ScCtrlConf;
import sketch.dyn.ctrls.ScGaCtrlConf;
import sketch.dyn.ga.base.ScGaIndividual;
import sketch.dyn.inputs.ScGaInputConf;
import sketch.dyn.inputs.ScInputConf;
import sketch.dyn.main.ScDynamicSketchCall;
import sketch.dyn.main.angelic.ScAngelicSketchBase;

public class ScDebugGaRun extends ScDefaultDebugRun {
    protected ScGaIndividual individual;
    protected ScGaCtrlConf ctrl_conf;
    protected ScGaInputConf oracle_conf;

    public ScDebugGaRun(ScDynamicSketchCall<ScAngelicSketchBase> sketch_call,
            ScGaIndividual individual, ScGaCtrlConf ctrl_conf,
            ScGaInputConf oracle_conf)
    {
        super(sketch_call);
        this.individual = individual;
        this.ctrl_conf = ctrl_conf;
        this.oracle_conf = oracle_conf;
    }

    @Override
    public void run_init() {
        individual.reset_fitness();
        individual.reset(ctrl_conf, oracle_conf);
    }

    @Override
    public ScCtrlConf get_ctrl_conf() {
        return ctrl_conf;
    }

    @Override
    public ScInputConf get_oracle_conf() {
        return oracle_conf;
    }
}
