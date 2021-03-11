package com.nhl.view;

import com.nhl.client.NhlApiService;
import com.nhl.data.team.Team;
import org.omnifaces.util.Messages;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("currentTeamListController")
@ViewScoped
public class TeamListController implements Serializable {

    @Inject
    private NhlApiService _nhlApiService;

    @Getter
    private List<Team> teamList;

    @PostConstruct  // After @Inject is complete
    public void init() {
        try {
            teamList = _nhlApiService.findAllTeam().getTeams();
        } catch (RuntimeException ex) {
            Messages.addGlobalError(ex.getMessage());
        }
    }
}