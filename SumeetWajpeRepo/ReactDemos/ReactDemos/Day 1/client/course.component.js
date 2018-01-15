
import React  from 'react';  // corrspnd to react folder in node_modules
export class CourseComponent extends React.Component{
    render(){
        return <div>
                    <h1> {this.props.coursedetails.name} </h1>
                    <b> Duration  : </b> {this.props.coursedetails.duration}
                    <hr/>
                    </div>
    }
}