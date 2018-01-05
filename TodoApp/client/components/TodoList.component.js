import React from 'react';
import AllTodos from './AllTodos';

class TodoList extends React.Component {
    render() {
        return <div className="container">
            <h2>TodoList</h2>
            {
                this.props.myTodos.map(
                    (todo, index)=>{
                        return <div>
                                <AllTodos todo={todo} key={index*Math.random()} {...this.props}/>
                            </div>
                    }
                )
            }
        </div>
    }
}

export default TodoList;