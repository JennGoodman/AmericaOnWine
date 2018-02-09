export class InventoryItem {
    name: string;
    year: number;
    type: string;
    country: string;
    url: string;

    constructor() {
        this.name = null;
        this.year = null;
        this.type = 'def';
        this.country = 'def';
        this.url = null;
    }
}
