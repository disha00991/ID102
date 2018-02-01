import React from 'react'
import { render } from 'react-dom'
import { Router, hashHistory } from 'react-router'

import { Provider } from 'react-redux'
import routes from 'routes'
import {  combineReducers, applyMiddleware } from 'redux'

import store from './store'

render(
    <Provider store={store}>
         <Router children={routes} history={hashHistory} />      
    </Provider>,
    document.getElementById("content")
)