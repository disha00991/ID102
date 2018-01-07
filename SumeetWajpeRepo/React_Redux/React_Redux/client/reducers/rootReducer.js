import {combineReducers} from 'redux';

import posts from './postReducer';
import comments from './commentReducer';
import fetchposts from './fetchReducer';

var rootReducer = combineReducers({
    posts,
    comments,
    fetchposts
    });

export default rootReducer;