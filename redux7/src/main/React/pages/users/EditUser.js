import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'

import {connect} from 'react-redux'
import * as actionCreators from 'actions/users'
import { hashHistory } from 'react-router'


import EditForm from 'components/users/EditForm'

class EditUserCmp extends React.Component {
    constructor(props) {
        super(props);
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this);
    }
    
    componentDidUpdate(prevProps){
        if(this.props.editUsers && this.props.editUsers !== prevProps.editUsers){
            hashHistory.push('/users')
        }
    }

    getUpdatingUser(){
    	let index = this.props.params.userId
    	var updateUser = this.props.users.find(function(user) {
    	  return user.get('id')==index;
    	});
    	return updateUser
    }
    
    render() {
    	
        return <div className="container-fluid">
            <div className="row">
                <div className="col-md-12">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <EditForm editUser = {this.props.editUser}  updateUser={this.getUpdatingUser()}/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    }
};


function mapStateToProps(state) {
    return {
    	editUsers: state.user.get('editUsers'),
    	users: state.user.get('users')
    }
}

export const EditUser = connect(mapStateToProps, actionCreators)(EditUserCmp)