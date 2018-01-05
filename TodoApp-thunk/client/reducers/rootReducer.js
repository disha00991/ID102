import {combineReducers} from 'redux';
import reduceTodo from './fetchTodoReducer';

var rootReducer = combineReducers({
   reduceTodo
    });

export default rootReducer;