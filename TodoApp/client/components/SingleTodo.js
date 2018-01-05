import React from 'react';
import { Link } from 'react-router';

class SingleTodo extends React.Component {
    render() {
        var completed = this.props.todo.completed ? "YES" : "FALSE";
        return (
            <div>
                <p>USERID: {this.props.todo.userId}</p><br />
                <p>ID: {this.props.todo.id}</p><br />
                <p>TITLE: {this.props.todo.title}</p><br />
                <p>COMPLETED: {completed}</p><br />
                <hr />
            </div>
        );
    }
}

export default SingleTodo;