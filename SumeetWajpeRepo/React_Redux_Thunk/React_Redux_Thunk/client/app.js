import React from 'react';
import ReactDOM from 'react-dom';
import {Router,Route,IndexRoute,browserHistory} from 'react-router';
import {Provider} from 'react-redux';
import './styles/style.styl';


import Album from './components/Album.component';
import Main from './components/Main.component';
import Photo from './components/Photo.component';
import App from './components/MainScript';

import store from './store';

var router = (
                <Provider store={store}>
                    <Router history={browserHistory}>
                        <Route path="/" component={App}>
                            <IndexRoute component={Album}></IndexRoute>
                            <Route path="/view/:id" component={Photo}></Route>
                        </Route>
                    </Router>
                </Provider>
    );

ReactDOM.render(router,document.getElementById('root'));