import { Injectable } from '@angular/core';

@Injectable()
export class MenuService {

  constructor() { }

  getMenu(): Array<any> {
    const menu = [
      { name: 'BnDeam', path: './BnDeam', children: [{}] },
      {
        name: 'BnDeamTest',
        path: './BnDeamTest',
        children: [
          {
            name: '/roue-de-la-vie',
            path: './roue-de-la-vie',

          }
        ]
      },
    ];

    return menu;
  }

}
