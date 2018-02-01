import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'

export default class UserForm extends React.Component {
    constructor(props) {
        super(props)
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this)
    }

    onSubmit(e){
        e.preventDefault()
        this.props.saveUser({name: this.refs.name.value , email: this.refs.email.value , contact: this.refs.contact.value })
    }

    render() {
        return <form onSubmit={this.onSubmit.bind(this)}>
            <div className="form-group">
                <label>User name</label>
                <input className="form-control" ref="name" />
                <label>User email</label>
                <input type="email" className="form-control" ref="email" />
                <label>User contact</label>
                <input type="number" className="form-control" ref="contact" />
            </div>
            <button type="submit" className="btn btn-fill btn-primary">Save</button>
        </form>
    }
}
