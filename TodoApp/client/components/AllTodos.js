import React from 'react';
import { Link } from 'react-router';

class AllTodos extends React.Component{
    render(){
        return(
            <div>
                <Link to={`/todo/${this.props.todo.id}`}>
                    <p>{this.props.todo.title}</p>                    
                </Link>
                <hr/>
            </div>
        );
    }
}

export default AllTodos;