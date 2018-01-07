export class ListOfCourses extends React.Component{

    constructor(){
        super();
        this.courses = [
            {name: "Angular",duration:'3 Days'},
            {name: "Backbone",duration:'2 Days'},
            {name: "React",duration:'3 Days'}
        ];       
    }
    render(){
        var coursesToBeCreated = this.courses.map(function(course,index){
            return <CourseComponent coursedetails={course} key={index * Math.random()}/>             
        });
     return   <div>
         {coursesToBeCreated}
    </div>
    }
}