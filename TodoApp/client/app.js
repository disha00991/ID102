import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRoute, browserHistory } from 'react-router';
import {Provider} from 'react-redux';

import Main from './components/Main.component';
import TodoList from './components/TodoList.component';
import Todo from './components/Todo.component';
import App from './components/MainScript';
import store from './store';

var router = (
    <Provider store={store}>
        <Router history={browserHistory}>
            <Route path="/" component={App}>
                <IndexRoute component={TodoList}></IndexRoute>
                <Route path="/todo/:todoId" component={Todo}>
                </Route>
            </Route>
        </Router>
    </Provider>
);

ReactDOM.render(router, document.getElementById('content'));
