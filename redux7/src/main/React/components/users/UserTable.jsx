import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'
import {Link} from 'react-router'
export default class UserTable extends React.Component {
    constructor(props) {
        super(props)
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this)
    }

	deleteUser(id){
		console.log('in delete user')
		console.log(id)
		this.props.deleteUser(id)
	}

    render() {
        return <table className="table table-stripped table-bordered">
            <thead>
            <tr>
                <th>User Id</th>
                <th>User Name</th>
                <th>User Email</th>
                <th>User Contact</th>
                <th>Update User</th>
                <th>Delete User</th>
            </tr>
            </thead>
            <tbody>
            {this.props.users.map(user => <tr key={user.get('id')}>
                <td>{user.get('id')}</td>
                <td>{user.get('name')}</td>
                <td>{user.get('email')}</td>
                <td>{user.get('contact')}</td>
                <td><Link to={`users/edit/${user.get('id')}`}><span className="glyphicon glyphicon-pencil"></span></Link></td>
                <td><Link onClick={this.deleteUser.bind(this,user.get('id'))}><span className="glyphicon glyphicon-trash"></span></Link></td>
            </tr>)}

            </tbody>
        </table>

    }
}
