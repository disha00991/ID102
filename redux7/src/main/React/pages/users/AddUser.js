import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'

import {connect} from 'react-redux'
import * as actionCreators from 'actions/users'
import { hashHistory } from 'react-router'


import UserForm from 'components/users/UserForm'

class AddUserCmp extends React.Component {
    constructor(props) {
        super(props);
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this);
    }

    componentDidUpdate(prevProps){
        if(this.props.savedUser && this.props.savedUser !== prevProps.savedUser){
            hashHistory.push('/users')
        }
    }

    render() {
        return <div className="container-fluid">
            <div className="row">
                <div className="col-md-12">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <UserForm saveUser = {this.props.saveUser} />
                        </div>
                    </div>
                </div>
            </div>
        </div>

    }
};


function mapStateToProps(state) {
    return {
        savedUser: state.user.get('saved')
    }
}

export const AddUser = connect(mapStateToProps, actionCreators)(AddUserCmp)