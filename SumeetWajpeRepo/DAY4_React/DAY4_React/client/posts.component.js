
import React  from 'react';  // corrspnd to react folder in node_modules
import ReactDOM from 'react-dom';
import { PostDetailComponent } from './postdetail.component';

export class PostsComponent extends React.Component{
    componentWillMount(){
        this.state = {posts:[],currPosts:[]};
    }
    componentDidMount(){
        // Make ajaxified request !
        $.get('https://jsonplaceholder.typicode.com/posts',(response)=>{  
            this.setState({posts:response});        
        });
    }

    AddPostItem(){
        let theInputValue = ReactDOM.findDOMNode(this.refs.txtPostId);      
        let thePost = this.state.posts.find(p => p.id ==(theInputValue.value))      
        this.setState({currPosts:this.state.currPosts.concat(thePost)});        
    }
    render(){
        var postsToBeCreated = this.state.currPosts.map((p,i)=>{
                return <PostDetailComponent postdetails={p} key={i * Math.random()} />
        });
        return <div>
                       <h1>Posts</h1>
                      Enter Post Id : <input type="text" ref="txtPostId" /> 
                      <input type="button" value="Add Post" onClick={this.AddPostItem.bind(this)} />
                      <hr/>
                      {postsToBeCreated}
                    </div>
    }
}