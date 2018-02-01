import React from 'react'
import { Route, IndexRoute } from 'react-router'

import {PageWithLeftBarLayout} from 'pages/PageWithLeftBarLayout'

import {SomePage} from 'pages/SomePage'
import {UsersList, AddUser , EditUser} from 'pages/users'

export default (
    <Route name="app" component={PageWithLeftBarLayout} path="/">
        <IndexRoute component={SomePage}/>
        <Route path="users" component={UsersList}/>
        <Route path="users/new" component={AddUser}/>
        <Route path="users/edit/:userId" component={EditUser}/>
    </Route>
)
