# rotX-Algorithm

Projekti i dytë nga lënda "Siguria e të dhënave"

Kodi ROTX është një algoritëm i thjeshtë i zëvendësimit të shkronjave, i cili përdoret për të zëvendësuar një shkronjë me shkronjën e X-të që pas saj në alfabet. Vlerën e X-it e cakton përdoruesi, dhe algoritmi punon në varësi të kësaj vlerë. ROT13 është një ndër algoritmet më të njohura ROTX, ku X është caktuar si 13. Ky algoritëm është i ngjashëm me kodin e Cezarit të Romës së lashtë, por është anasjelltas me të, pasi ka 26 shkronja në alfabetin latin, dhe kjo bën që ROT13 të jetë i përshtatshëm për kodim dhe dekodim. Megjithatë, kjo metodë nuk ofron siguri kriptografike dhe shpesh citohet si një shembull i dobët i enkriptimit.

Ky program është një shembull i thjeshtë i enkriptimit dhe dekriptimit të tekstit përmes algoritmit simetrik AES (Advanced Encryption Standard).
Programi kërkon që përdoruesi të vendosë tekstin që dëshiron të enkriptojë, gjatësinë e çelësit simetrik (16, 24 ose 32 bajt), dhe rotacionin e alfabetit të caktuar nga përdoruesi.

Pasi pranon këto informacione nga përdoruesi, programi enkripton tekstin duke përdorur çelësin dhe algoritmin AES dhe pastaj shfaq mesazhin e enkriptuar në ekran. Në vijim, programi kërkon nga përdoruesi që të zgjedhë nëse dëshiron të shohë tekstin e dekriptuar ose jo.

Nëse përdoruesi zgjedh të shohë tekstin e dekriptuar, programi dekripton tekstin e enkriptuar duke përdorur të njëjtin çelës dhe algoritëm AES dhe shfaq tekstin e dekriptuar në ekran.

Përveç enkriptimit dhe dekriptimit të tekstit përmes AES, programi gjithashtu përmban funksionet rotXEncrypt dhe rotXDecrypt, që mundësojnë enkriptimin dhe dekriptimin e tekstit duke përdorur një rotacion të caktuar të alfabetit, të zgjedhur nga përdoruesi. Ky funksion është implementuar në mënyrë të thjeshtë, duke llogaritur indeksin e shkronjës origjinale në alfabetin ROTX dhe pastaj duke gjetur shkronjën e re duke llogaritur indeksin e ri në alfabetin ROTX.

Përdoruesi mund të zgjedhë një rotacion të caktuar për enkriptimin e tekstit, dhe programi shfaq mesazhin e enkriptuar përmes rotacionit të caktuar, si dhe dekripton tekstin përmes të njëjtit rotacion dhe shfaq tekstin e dekriptuar në ekran.
