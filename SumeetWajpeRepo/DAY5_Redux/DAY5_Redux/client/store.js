import {createStore} from 'redux';
import rootReducer from './reducers/rootReducer';

import posts from './data/posts';
import comments from './data/comments';

var defaultStore = {posts,comments};

var store = createStore(rootReducer,defaultStore);

export default store;