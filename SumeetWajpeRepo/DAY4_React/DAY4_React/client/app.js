// Code Here

import React     from 'react';  // corrspnd to react folder in node_modules
import ReactDOM from 'react-dom';
import {BasicComponent} from './basic.component';
import {CourseComponent} from './course.component';
import {CustomButtonComponent} from './custombutton.component';
import {ButtonListComponent} from './buttonlist.component';
import {LifeCycleComponent} from './lifecycle.component';
import {PostsComponent} from './posts.component';

// ReactDOM.render(<CustomButtonComponent 
//     initialCount={10}/> , 
//     document.getElementById('content'))

// ReactDOM.render(<ButtonListComponent countvalues={[10,50,20,70,40]} /> , 
//     document.getElementById('content'))

   
ReactDOM.render(<PostsComponent /> , 
    document.getElementById('content')) 