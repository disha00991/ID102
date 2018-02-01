import request from 'axios'

import { USERS_SAVED, AJAX_BEGIN, AJAX_END, USERS_ALL ,USER_EDIT } from 'actions/actionTypes'

export function saveUser(userToSave) {

    return function(dispatch){
        dispatch({ type: AJAX_BEGIN })

        return request.post('/api/users/save', userToSave )
            .then(function(response){
                dispatch({ type:USERS_SAVED, saved : response.data })
                dispatch({ type: AJAX_END })
            })
            .catch(function(response){
                dispatch({ type: AJAX_END })
            })
    }
}

export function loadAllUsers() {

    return function(dispatch){
        dispatch({ type: AJAX_BEGIN })

        return request.get('/api/users/all' )
            .then(function(response){
                dispatch({ type: USERS_ALL, users : response.data })
                dispatch({ type: AJAX_END })
            })
            .catch(function(response){
                dispatch({ type: AJAX_END })
            })
    }
}
    export function editUser(userToEdit) {

        return function(dispatch){
            dispatch({ type: AJAX_BEGIN })

            return request.put('/api/users/edit' ,userToEdit)
                .then(function(response){
                    dispatch({ type: USER_EDIT, users : response.data })
                    dispatch({ type: AJAX_END })
                })
                .catch(function(response){
                    dispatch({ type: AJAX_END })
                })
        }
}
    
    export function deleteUser(userId) {

        return function(dispatch){
            dispatch({ type: AJAX_BEGIN })

            return request.delete('/api/users/delete/'+userId)
            .then(function(response){
                dispatch({ type: USERS_ALL, users : response.data })
                dispatch({ type: AJAX_END })
            })
            .catch(function(response){
                dispatch({ type: AJAX_END })
            })
    }
}