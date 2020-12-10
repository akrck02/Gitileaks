let person = ((name) => {
    return {
        getName: function() {
            return name;
        }
    }
})("Luis Miguel");

console.log(person.getName());