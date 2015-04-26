/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.betances.grid;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author pleymo
 */
@Theme("valo")
@SpringUI
public class GridUI extends UI{
    
    @Autowired
    private SpringViewProvider springViewProvider;
    
    @Override
    protected void init(VaadinRequest request) {
        
        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(springViewProvider);
        
    }
    
}
