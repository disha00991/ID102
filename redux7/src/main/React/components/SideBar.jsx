import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'
import { Link } from 'react-router'


export default class SideBar extends React.Component {
    constructor(props) {
        super(props)
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this)
    }

    render() {
        return     <div className="sidebar" data-color="blue">

            <div className="sidebar-wrapper">
                <div className="logo">

                    <Link to="/" className="simple-text">
                        HOME
                    </Link>

                </div>

                <ul className="nav">
                    <li>
                        <Link to="/users">
                            <i className="pe-7s-ribbon"></i>
                            Users
                        </Link>
                    </li>

                    <li>
                        <Link to="/users/new">
                            <i className="pe-7s-ribbon"></i>
                            Add User
                        </Link>
                    </li>

                </ul>
            </div>
        </div>

    }
}
