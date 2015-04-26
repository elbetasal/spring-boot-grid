/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.betances.grid;

import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.vaadin.data.Container;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.DateRenderer;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author pleymo
 */
@SpringView
public class GridView extends VerticalLayout implements View,ItemClickEvent.ItemClickListener,FieldGroup.CommitHandler {
    
    @Autowired
    private BookRepository repository;
    
    private Grid grid;
    
    @PostConstruct
    public void init(){
        for(int i = 0;i<100;i++){
            repository.save(new Book("AUthor"+i,"Title"+i,new Date()));
        }
        grid = new Grid(createContainer());         
        grid.getColumn("publicationDate").setRenderer(new DateRenderer("%1$tB %1$te, %1$tY"));
        grid.addItemClickListener(this);
        grid.getEditorFieldGroup().addCommitHandler(this);
        addComponent(grid);
    }
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
    }
    
    private Container.Indexed  createContainer(){
        Collection<Book> books = Lists.newArrayList(repository.findAll());
        BeanItemContainer container = new BeanItemContainer(Book.class,books);
        
        return container;
    }

    @Override
    public void itemClick(ItemClickEvent event) {                
        if( ((BeanItem<Book>)event.getItem()).getBean().getAuthor().equals("AUthor2") ){
            grid.setEditorEnabled(true);                        
        }else{
            grid.setEditorEnabled(false);
        }
        if(event.isDoubleClick() && grid.isEditorEnabled()){
            grid.editItem(event.getItemId());
        }
        
    }

    @Override
    public void preCommit(FieldGroup.CommitEvent commitEvent) throws FieldGroup.CommitException {
        
    }

    @Override
    public void postCommit(FieldGroup.CommitEvent commitEvent) throws FieldGroup.CommitException {
        
    }
    
}
