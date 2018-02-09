import React from 'react'

import {connect} from 'react-redux'

import { browserHistory, Link } from 'react-router'
import {NavBar} from 'components/NavBar'
import SideBar from 'components/SideBar'
import Footer from 'components/Footer'
import Ticker from 'components/Ticker'
import TradeNotification from 'components/TradeNotification'

export class PageWithLeftBarLayout extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return <div className="wrapper">
        <NavBar />
            <div className="main-panel">
                <Ticker />
                <TradeNotification />
            </div>
        </div>
    }
}

