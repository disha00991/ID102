

import {combineReducers} from 'redux';
import posts from './postsReducer';
import comments from './commentsReducer';


var rootReducer = combineReducers({
    posts,
    comments
})

export default rootReducer;