import React from 'react';
import SingleTodo from './SingleTodo';

class Todo extends React.Component {
    render() {

        var id = this.props.params.todoId;
        var index = this.props.myTodos.findIndex((todo)=>{
            return todo.id == id;
        });

        var currTodo = this.props.myTodos[index];
        return <div className="container">
            <h2>Todo</h2>
            <SingleTodo todo={currTodo} {...this.props}/>
        </div>
    }
}

export default Todo;