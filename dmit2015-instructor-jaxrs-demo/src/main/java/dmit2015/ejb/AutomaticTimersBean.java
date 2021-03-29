package dmit2015.ejb;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import java.util.logging.Logger;

@Singleton
@Startup
public class AutomaticTimersBean {

    private Logger _logger = Logger.getLogger(AutomaticTimersBean.class.getName());

//    @Schedule(hour = "14", minute = "22", info="batchletEnforcementZoneCentre")
    public void startBatchlet(Timer timer) {
        String jobXMLName = (String) timer.getInfo();
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long jobExecutionId = jobOperator.start(jobXMLName,null);
        _logger.info("Started batch job " + jobExecutionId);
    }
}
