import React from 'react'
import { Route, IndexRoute } from 'react-router'

import {PageWithLeftBarLayout} from 'pages/PageWithLeftBarLayout'

import {SomePage} from 'pages/SomePage'

export default (
    <Route name="app" component={PageWithLeftBarLayout} path="/">
    </Route>
)
