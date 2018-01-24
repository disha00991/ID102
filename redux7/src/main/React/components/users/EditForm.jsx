import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'

export default class EditForm extends React.Component {
    constructor(props) {
        super(props)
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this)
    }

    onSubmit(e){
        e.preventDefault()
        this.props.editUser({id:this.props.updateUser.get('id') , name: this.refs.name.value , email: this.refs.email.value , contact: this.refs.contact.value })
    }

	onValueChange(e){
			 e.preventDefault()
			 console.log('change ho ra hai')
			 this.props.updateUser.set('name',this.refs.name.value)
			 this.props.updateUser.set('email',this.refs.email.value)
			 this.props.updateUser.set('contact',this.refs.contact.value)
			 
	}

    render() {
        return <form onSubmit={this.onSubmit.bind(this)}>
            <div className="form-group">
            	<label>User Id</label>
                <input className="form-control" placeholder={this.props.updateUser.get('id')} readOnly/>
                <label>User name</label>
                <input className="form-control" defaultValue={this.props.updateUser.get('name')} ref="name" />
                <label>User email</label>
                <input type="email" className="form-control" defaultValue={this.props.updateUser.get('email')} ref="email" />
                <label>User contact</label>
                <input type="number" className="form-control" defaultValue={this.props.updateUser.get('contact')} ref="contact" />
            </div>
            <button type="submit" className="btn btn-fill btn-primary">Edit</button>
        </form>
    }
}
