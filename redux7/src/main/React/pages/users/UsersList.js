import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'

import {connect} from 'react-redux'
import * as actionCreators from 'actions/users'

import UserTable from 'components/users/UserTable'

class UsersListCmp extends React.Component {
    constructor(props) {
        super(props);
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this);
    }

    componentDidMount(){
        this.props.loadAllUsers()
    }

    getUsers(){
        if(!this.props.users){
            return []
        }

        return this.props.users
    }

    render() {
        return <div className="container-fluid">
            <div className="row">
                <div className="col-md-12">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <UserTable users = {this.getUsers()} deleteUser={this.props.deleteUser}/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    }
};


function mapStateToProps(state) {
    return {
        needRefresh: state.user.get('needRefresh'),
        users: state.user.get('users')
    }
}

export const UsersList = connect(mapStateToProps, actionCreators)(UsersListCmp)