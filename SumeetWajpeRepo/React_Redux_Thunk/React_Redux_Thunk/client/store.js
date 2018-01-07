import {createStore,applyMiddleware } from 'redux';

import rootReducer from './reducers/rootReducer';

import posts from './data/posts';
import comments from './data/comments';

var defaultState = {posts,comments};

var store = createStore(rootReducer,defaultState);
    //window.__REDUX_DEVTOOLS_EXTENSION__ && 
    //window.__REDUX_DEVTOOLS_EXTENSION__());

export default store;