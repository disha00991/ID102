import {Map} from 'immutable'
import { USERS_SAVED, USERS_ALL , USER_EDIT} from 'actions/actionTypes'

export default function userReducer(state = Map(), action) {
    switch(action.type) {

        case USERS_SAVED:
            return state.merge({
                saved: action.saved
            })

        case USERS_ALL:
            return state.merge({
                users: action.users
            })
            
        case USER_EDIT:
            return state.merge({
                editUsers: action.users
            })

        default:
            return state
    }
}