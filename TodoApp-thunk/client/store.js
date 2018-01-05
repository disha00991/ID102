import {createStore, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import rootReducer from './reducers/rootReducer';
console.log("Store");
var store = createStore(rootReducer, applyMiddleware(thunk));
console.log(store);
export default store;

