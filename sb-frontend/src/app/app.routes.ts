import { Routes } from '@angular/router';
import { ListStudent } from './list-student/list-student';
import { ViewStudent } from './view-student/view-student';
import { CreateStudent } from './create-student/create-student';
import { EditStudent } from './edit-student/edit-student';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'get',
        pathMatch: 'full'
    },
    {
        path: 'get',
        component: ListStudent
    },
    {
        path: 'getbyId/:id',
        component: ViewStudent
    },
    {
        path: 'create',
        component: CreateStudent
    },
    {
        path: 'updateById/:id',
        component: EditStudent
    },
    {
        path: '**',             
        redirectTo: 'get'
    }
];
