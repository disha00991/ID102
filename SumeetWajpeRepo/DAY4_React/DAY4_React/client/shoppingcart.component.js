import React from 'react'; // node_modules
import ProductComponent from './product.component';

export default class ShoppingCartComponent extends React.Component{

    constructor(props){
        super(props);
        this.state ={
            products: [
            {Name:'Laptop',Price:50000,Quantity:20,Rating:4},
            {Name:'Camera',Price:25000,Quantity:30,Rating:4},
            {Name:'LED TV',Price:60000,Quantity:20,Rating:4},
            {Name:'Desktop',Price:30000,Quantity:10,Rating:4},
            {Name:'PS 2',Price:90000,Quantity:90,Rating:4}
            ]
        }
    }    
    render(){
      var  productsToBcreated = this.state.products.map(function(product,index){
        return    <ProductComponent pdetails={product} key={index * Math.random()}  />
      });
        return <div>
                <h1> Shopping Cart </h1>
                {productsToBcreated} 
            </div>
    }
}



