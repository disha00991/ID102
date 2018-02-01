import React from 'react'
import { Route, IndexRoute } from 'react-router'

import Trade from 'components/TradeComponent'

import App from 'components/MainScript'
import TradeMapping from 'components/TradeMapping'


export default (
   <Route path='/' component={App}>
    <IndexRoute component={Trade}></IndexRoute>
    <Route path='/edit/:tid' component={TradeMapping}></Route>
    </Route>
)
