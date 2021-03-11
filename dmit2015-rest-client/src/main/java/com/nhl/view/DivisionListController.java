package com.nhl.view;

import com.nhl.client.NhlApiService;
import com.nhl.data.division.Division;
import org.omnifaces.util.Messages;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("currentDivisionListController")
@ViewScoped
public class DivisionListController implements Serializable {

    @Inject
    private NhlApiService _nhlApiService;

    @Getter
    private List<Division> divisionList;

    @PostConstruct  // After @Inject is complete
    public void init() {
        try {
            divisionList = _nhlApiService.findAllDivision().getDivisions();
        } catch (RuntimeException ex) {
            Messages.addGlobalError(ex.getMessage());
        }
    }
}