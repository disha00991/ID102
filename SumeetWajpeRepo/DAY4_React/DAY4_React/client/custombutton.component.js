
import React  from 'react';  // corrspnd to react folder in node_modules
export class CustomButtonComponent extends React.Component{
    
    constructor(props){
        super(props);
        this.state = {count:this.props.initialCount};
    }


    IncreementCount(){
            // ??
            //this.props.initialCount=this.props.initialCount + 1;
            //console.log(this.props.initialCount);
           
            this.setState({count:this.state.count + 1});

    }
    
    render(){
        return <div>
                    <input
                    className="btn btn-primary"
                     type="button" 
                     value={this.state.count}
                     onClick={this.IncreementCount.bind(this)}
                     />
                      </div>
    }
}