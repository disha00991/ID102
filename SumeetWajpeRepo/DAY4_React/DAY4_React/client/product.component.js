import React from 'react'; // node_modules

export default class ProductComponent extends React.Component{
    constructor(props){
        super(props);
    }

    render(){
        return <div>
                 <h2> {this.props.pdetails.Name} </h2>
                 <b>Price : </b>  {this.props.pdetails.Price}  <br/>
                 <b>Quantity :  </b> {this.props.pdetails.Quantity} <br/>
                 <b>Rating: </b>{this.props.pdetails.Rating}  <br/>  
                 <hr/>               
                    </div>
    }
}



