// Code Here

import React from 'react';
import ReactDOM from 'react-dom';
import {Router,Route,IndexRoute,browserHistory} from 'react-router';

import Main from './components/Main.component';
import Album from './components/Album.component';
import Photo from './components/Photo.component';
import App from './components/MainScript';

import {Provider} from 'react-redux';
import store from './store';

var router = (<Provider store={store}>
                        <Router history={browserHistory}>
                            <Route path="/" component={App}>
                                <IndexRoute component={Album}></IndexRoute>
                                <Route path="/photo" component={Photo}>
                                </Route>
                            </Route>                           
                        </Router>
                        </Provider>
);

ReactDOM.render(router,document.getElementById('content'))