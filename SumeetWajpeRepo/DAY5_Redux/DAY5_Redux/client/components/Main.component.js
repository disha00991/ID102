import React from 'react';

class Main extends React.Component{
    render(){
        return <div>
            <h1> Main Component</h1>            
            {React.cloneElement(this.props.children,this.props)}
                    </div>
    }
}

export default Main;