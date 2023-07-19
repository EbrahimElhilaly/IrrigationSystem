/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.automatic.irrigation.controller;

import java.util.List;
import java.util.Optional;
import org.automatic.irrigation.entity.Plot;
import org.automatic.irrigation.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/plot")
public class PlotController {

    @Autowired
    private PlotService plotService;

    @PostMapping
    public ResponseEntity<Plot> addPlot(@RequestBody Plot plot) {
        Plot newPlot = plotService.addPlot(plot);
        return new ResponseEntity<>(newPlot, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plot> updatePlot(@PathVariable Long id, @RequestBody Plot plot) {
        Optional<Plot> optionalPlot = plotService.getPlotById(id);
        if (optionalPlot.isPresent()) {
            Plot updatedPlot = optionalPlot.get();
            updatedPlot.setName(plot.getName());
            updatedPlot.setLocation(plot.getLocation());
            updatedPlot.setSize(plot.getSize());
            updatedPlot = plotService.updatePlot(updatedPlot);
            return new ResponseEntity<>(updatedPlot, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Plot>> getAllPlots() {
        List<Plot> plots = plotService.getAllPlots();
        return new ResponseEntity<>(plots, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plot> getPlotById(@PathVariable Long id) {
        Optional<Plot> optionalPlot = plotService.getPlotById(id);
        return optionalPlot.map(plot -> new ResponseEntity<>(plot, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlotById(@PathVariable Long id) {
        plotService.deletePlotById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


