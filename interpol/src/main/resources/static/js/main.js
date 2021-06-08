
function CardsName( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){
        console.log(cards[i].name);
        console.log(j);
        if (cards[i].name != j){
            cards.splice(i, 1);
            CardsName(cards,j);
        }

    }

}

function CardsId( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){
        console.log(cards[i].id);
        console.log(j);
        if (cards[i].id != j){
            cards.splice(i, 1);
            CardsId(cards,j);
        }

    }

}

function CardsFn( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){
        console.log(cards[i].familyName);
        console.log(j);
        if (cards[i].familyName != j){
            cards.splice(i, 1);
            CardsFn(cards,j);
        }

    }

}
function CardsNn( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){

        console.log(cards[i].nickName);
        console.log(j);
        if (cards[i].nickName != j){
            cards.splice(i, 1);
            CardsNn(cards,j);
        }

    }

}

function CardsH( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){

        console.log(cards[i].height);
        console.log(j);
        if (cards[i].height != j){
            cards.splice(i, 1);
            CardsH(cards,j);
        }

    }

}

function CardsHc( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){

        console.log(cards[i].hairColor);
        console.log(j);
        if (cards[i].hairColor != j){
            cards.splice(i, 1);
            CardsHc(cards,j);
        }

    }

}
function CardsEc( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){

        console.log(cards[i].eyesColor);
        console.log(j);
        if (cards[i].eyesColor != j){
            cards.splice(i, 1);
            CardsEc(cards,j);
        }

    }

}

function CardsC( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){

        console.log(cards[i].citizenship);
        console.log(j);
        if (cards[i].citizenship != j){
            cards.splice(i, 1);
            CardsC(cards,j);
        }

    }

}


function CardsBd( cards , j){
    console.log(cards.length);
    for(let i = 0; i < cards.length; i++){

        console.log(cards[i].birthDay);
        console.log(j);
        if (cards[i].birthDay != j){
            cards.splice(i, 1);
            CardsBd(cards,j);
        }

    }

}





function getValue(text){
    if (document.getElementById(text).value != ''){
        return document.getElementById(text).value ;
    }else{
        return null;
    }

}

function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}


var cardApi = Vue.resource('/cards{/id}');

Vue.component('card-form', {
    props: ['cards', 'cardAttr'],
    data: function() {
        return {
            id: '',
            Name: '',
            FamilyName: '',
            nname: '',
            height: '',
            hcolor: '',
            ecolor: '',
            citizenship: '',
            blocation: '',
            specialization: '',
            bdate: ''
        }
    },
    watch: {
        cardAttr: function(newVal, oldVal) {
            this.text = newVal.text;
            this.id = newVal.id;
        }
    },
    template:
        '<div style="width: 300px;">' +
        '<input type="text" placeholder="Write Name" v-model="Name" />' +
        '<input type="text" placeholder="Write Familyname" v-model="FamilyName" />' +
        '<input type="text" placeholder="Write Nickname" v-model="nname" />' +
        '<input type="text" placeholder="Write Height" v-model="height" />' +
        '<input type="text" placeholder="Write HairColor" v-model="hcolor" />' +
        '<input type="text" placeholder="Write EyesColor" v-model="ecolor" />' +
        '<input type="text" placeholder="Write Citizenship" v-model="citizenship" />' +
        '<input type="text" placeholder="Write BirthLocation" v-model="blocation" />' +
        '<input type="text" placeholder="Write Specialization" v-model="specialization" />' +
        '<input type="date"  v-model="bdate" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var card = { name: this.Name ,
                familyName: this.FamilyName ,
                nickName: this.nname ,
                height: this.height ,
                hairColor: this.hcolor ,
                eyesColor: this.ecolor ,
                citizenship: this.citizenship ,
                birthLocation: this.blocation ,
                specialization: this.specialization ,
                birthDay: this.bdate}

            console.log(card);
            cardApi.save({}, card).then(result =>
                result.json().then(data => {
                    this.cards.push(data);

                })
            )
        }
    }
});

Vue.component('card-row', {
    props: ['card', 'cards'],
    template: '<div class="item-container">' +
        '<div class="item">({{ card.id }})</div> <div class="item">{{ card.name }}</div> <div class="item">{{ card.familyName }}</div>' +
        '<div class="item">{{ card.nickName }}</div><div class="item">{{ card.height }}</div>' +
        '<div class="item">{{ card.hairColor }}</div> <div class="item">{{ card.eyesColor }}</div>' +
        '<div class="item">{{ card.citizenship }}</div> <div class="item">{{ card.birthLocation }}</div>' +
        '<div class="item">{{ card.specialization }}</div> <div class="item_date">{{ card.birthDay }}</div>' +
        '<span style="position: absolute; right: 0">'  +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {

        del: function() {
            cardApi.remove({id: this.card.id}).then(result => {
                if (result.ok) {
                    this.cards.splice(this.cards.indexOf(this.card), 1);
                }
            })
        }
    }
});

Vue.component('card-list', {
    props: ['cards' ],
    data:
        function() {

        return {
            card: null,
            cards_buf: [],
            cards_finl: []
        }

    },
    template:
        '<div style="position: relative; ">' +
        '<card-form :cards="cards" :cardAttr="card" />' +
        '<div><input id="id_inp" type="text" placeholder="Id"/><input id="name_inp" type="text" placeholder="Name"/>' +
        '<input id="fn_inp" type="text" placeholder="Family Name"/><input id="nn_inp" type="text" placeholder="NickName"/> ' +
        '<input id="height_inp" type="text" placeholder="Height"/><input id="hc_inp" type="text" placeholder="Hair Color"/>' +
        '<input id="ec_inp" type="text" placeholder="Eyes Color"/><input id="cit_inp" type="text" placeholder="Citizenship"/> ' +
        '<input id="but_inp" type="text" placeholder="Birth Day"/> <input type="button" value="Search" @click="search"/></div>' +
        '<card-row v-for="card in cards" :key="card.id" :card="card" ' +
        ' :cards="cards" />' +
        '</div>',
    created: function() {
        cardApi.get().then(result =>
            result.json().then(data =>
                data.forEach(card => this.cards.push(card))
            )
        )
    },

    methods: {
        search: function (){



            let map = new Map();
            map.set('id_inp' , getValue('id_inp'));
            map.set('name_inp' , getValue('name_inp'));
            map.set('fn_inp' , getValue('fn_inp'));
            map.set('nn_inp' , getValue('nn_inp'));
            map.set('height_inp' , getValue('height_inp'));
            map.set('hc_inp' , getValue('hc_inp'));
            map.set('ec_inp' , getValue('ec_inp'));
            map.set('cit_inp' , getValue('cit_inp'));
            map.set('but_inp' , getValue('but_inp'));
            console.log(this.cards);
            if(map.get('name_inp') != null){
                CardsName(this.cards , map.get('name_inp'));
            }
            if(map.get('id_inp') != null){
                CardsId(this.cards , map.get('id_inp'));
            }
            if(map.get('fn_inp') != null){
                CardsFn(this.cards , map.get('fn_inp'));
            }if(map.get('nn_inp') != null){
                CardsNn(this.cards , map.get('nn_inp'));
            }if(map.get('height_inp') != null){
                CardsH(this.cards , map.get('height_inp'));
            }
            if(map.get('hc_inp') != null){
                CardsHc(this.cards , map.get('hc_inp'));
            }
            if(map.get('ec_inp') != null){
                CardsEc(this.cards , map.get('ec_inp'));
            }
            if(map.get('cit_inp') != null){
                CardsC(this.cards , map.get('cit_inp'));
            }
            if (map.get('but_inp') != null){
                CardsBd(this.cards , map.get('but_inp'));
            }
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<card-list :cards="cards" />',
    data: {
        cards: []
    }
});