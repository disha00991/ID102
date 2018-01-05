import {createStore} from 'redux';
import todos from './data/todos.js';

var defaultStore = {todos};

function dummyReducer(state = [], action ){
    return state;
}

var store = createStore(dummyReducer, defaultStore);

export default store;

