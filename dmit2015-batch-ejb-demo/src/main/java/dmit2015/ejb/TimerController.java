package dmit2015.ejb;

import javax.ejb.Timer;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class TimerController {

    @Inject
    private ProgrammaticTimersManagerBean timerBean;

    public String cancelAllTimers() {
        timerBean.cancelAllTimers();;
        return "";
    }

    public Collection<Timer> list() {
        return timerBean.listAllTimers();
    }

    public void cancelTimer(Timer selectedTimer) {
        timerBean.cancelTimer(selectedTimer);
    }
}