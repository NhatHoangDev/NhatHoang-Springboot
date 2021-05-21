var employees = [];

function findEmployee (employeeId) {
    return employees[findEmployeeKey(employeeId)];
}

function findEmployeeKey (employeeId) {
    for (var key = 0; key < employees.length; key++) {
        if (employees[key].id == employeeId) {
            return key;
        }
    }
}

var employeeService = {
    findAll(fn) {
        axios
            .get('/api/v1/employees')
            .then(response => fn(response))
            .catch(error => console.log(error))
    },
    create(employee, fn) {
        axios
            .post('/api/v1/employees', employee)
            .then(response => fn(response))
            .catch(error => console.log(error))
    },

    update(id, employee, fn) {
        axios
            .put('/api/v1/employees/' + id, employee)
            .then(response => fn(response))
            .catch(error => console.log(error))
    },


}

var List = Vue.extend({
    template: '#employee-list',
    data: function () {
        return {employees: [], searchKey: ''};
    },
    computed: {
        filteredEmployees() {
            return this.employees.filter((employee) => {
                return employee.name.indexOf(this.searchKey) > -1
                    || employee.salary.indexOf(this.searchKey) > -1
            })
        }
    },
    mounted() {
        employeeService.findAll(r => {this.employees = r.data; employees = r.data})
    }
});

var Employee = Vue.extend({
    template: '#employee',
    data: function () {
        return {employee: findEmployee(this.$route.params.employee_id)};
    }
});

var EmployeeEdit = Vue.extend({
    template: '#employee-edit',
    data: function () {
        return {employee: findEmployee(this.$route.params.employee_id)};
    },
    methods: {
        updateEmployee: function () {
            employeeService.update(this.employee.id, this.employee, r => router.push('/'))
        }
    }
});

var AddEmployee = Vue.extend({
    template: '#add-employee',
    data() {
        return {
            employee: {name: '', salary: 0}
        }
    },
    methods: {
        createEmployee() {
            employeeService.create(this.employee, r => router.push('/'))
        }
    }
});

var router = new VueRouter({
    routes: [
        {path: '/', component: List},
        {path: '/add-employee', component: AddEmployee},
        {path: '/employee/:employee_id', component: Employee, name: 'employee'},
        {path: '/employee/:employee_id/edit', component: EmployeeEdit, name: 'employee-edit'}]
});

new Vue({
    router
}).$mount('#app')
